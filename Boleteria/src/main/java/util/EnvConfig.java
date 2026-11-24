package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig {
	private static final Properties properties = new Properties();

	private static String ruta = System.getProperty("user.dir")+"/.env";
	
	static {
		try (FileInputStream file = new FileInputStream(ruta)) {
			properties.load(file);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo cargar .env", e);
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
