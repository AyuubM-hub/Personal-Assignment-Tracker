public class Module {

    private int moduleId;
    private String moduleName;
    private String moduleCode;

    public Module(int moduleId, String moduleName, String moduleCode) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

    public int getModuleId() {
        return moduleId;
    }
    
    public String getModuleName() {
        return moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }
}