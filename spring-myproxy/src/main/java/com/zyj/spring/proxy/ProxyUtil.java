package com.zyj.spring.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {

	public static Object newInstance(Class targetInterface, IInvocationHandler handler) {
		String line = "\n";
		String tab = "\t";
		Method[] methods = targetInterface.getDeclaredMethods();
		String classContent = "";
		String targetInterfaceName = targetInterface.getSimpleName();
		String packageContent = "package com.google;" + line;
		String importContent = "import " + targetInterface.getName() + ";" + line;
		importContent += "import com.zyj.spring.proxy.IInvocationHandler;" + line;
		importContent += "import java.lang.reflect.Method;" + line;
		String clazzFirstLineContent = "public class $Proxy implements " + targetInterfaceName + "{" + line;
		String filedContent = tab + "private IInvocaionHandler handler;"  + line;
		String constructorContent = tab + "public $Proxy(IInvocationHandler handler) {this.handler = handler;}"  + line;
		String methodContent = "";
		String parametercontent = "";
		for (Method method : methods) {
			String returnTypeName = method.getReturnType().getSimpleName();
			String methodName = method.getName();
			Class[] methodParameterTypes = method.getParameterTypes();
			methodContent += tab + "public " + returnTypeName + " " + methodName + "(";
			for (int i = 0; i < methodParameterTypes.length; i++) {
				if (i == methodParameterTypes.length - 1) {
					methodContent += methodParameterTypes[i].getSimpleName() + " arg" + i;
					parametercontent += "arg" + i;
				} else {
					methodContent += methodParameterTypes[i].getSimpleName() + " arg" + i + ",";
					parametercontent += "arg" + i + ",";
				}
			}
			methodContent += ") throws Exception {" + line;
			if (parametercontent != "") {
				methodContent += tab + tab + "Method method = Class.forName(\"" + targetInterface.getName() + "\").getDeclaredMethod(\"" + methodName + "\"," + parametercontent + ");" + line;
			} else {
				methodContent += tab + tab + "Method method = Class.forName(\"" + targetInterface.getName() + "\").getDeclaredMethod(\"" + methodName + "\");" + line;
			}

			if (returnTypeName != "void") {
				if (parametercontent != "") {
					methodContent += tab + tab + "return (" + returnTypeName + ") handler.invoke(method," + parametercontent + ");" + line;
				} else {
					methodContent += tab + tab + "return (" + returnTypeName + ") handler.invoke(method);" + line;
				}
			} else {
				if (parametercontent != "") {
					methodContent += tab + tab + "handler.invoke(method," + parametercontent + ");" + line;
				} else {
					methodContent += tab + tab + "handler.invoke(method);" + line;
				}
			}
			methodContent += "}" + line;
			parametercontent = "";
		}
		classContent = packageContent + importContent + clazzFirstLineContent + filedContent + constructorContent + methodContent + "}";
		File file = new File("E:\\com\\google\\$Proxy.java");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(classContent);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileManager.getJavaFileObjects(file);
		JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
		t.call();
		try {
			fileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		URL url = null;
		Object object = null;
		try {
			url = new URL("file:E:\\");
			URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url});
			Class clazz = loader.loadClass("com.google.$Proxy");
			Constructor constructor = clazz.getConstructor(targetInterface);
//			object = constructor.newInstance(targetObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
