package utils;
/**
 * @author Ibraiym Denizov
 */
public class Settings {

    public final static String BASEURL = ConfigurationReader.getProperty("baseUrl");
    public final static String BROWSER = ConfigurationReader.getProperty("browser");
    public final static String EMPLOYEE_EMAIL = ConfigurationReader.getProperty("employeeEmail");
    public final static String EMPLOYEEPASSWORD = ConfigurationReader.getProperty("employeePassword");
    public final static String MANAGER_EMAIL = ConfigurationReader.getProperty("managerEmail");
    public final static String MANAGERPASSWORD = ConfigurationReader.getProperty("managerPassword");
    public final static int DEFAULTWAITTIME = Integer.parseInt(ConfigurationReader.getProperty("defaultWaitTime"));
    public final static int IMPLICITWAITTIME = Integer.parseInt(ConfigurationReader.getProperty("implicitWaitTime"));
}
