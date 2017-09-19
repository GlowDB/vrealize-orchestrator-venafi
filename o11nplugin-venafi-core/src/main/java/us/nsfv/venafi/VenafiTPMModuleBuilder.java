package us.nsfv.venafi;

import com.vmware.o11n.plugin.sdk.module.ModuleBuilder;
import us.nsfv.venafi.model.*;

public final class VenafiTPMModuleBuilder extends ModuleBuilder {

    private static final String DESCRIPTION = "Venafi TPM plug-in for vRealize Orchestrator";

    private static final String DATASOURCE = "main-datasource";

    @Override
    public void configure() {
        module("VenafiTPM").withDescription(DESCRIPTION).withImage("images/default-32x32.png")
                .basePackages(VenafiTPMModuleBuilder.class.getPackage().getName()).version(
                "${project.version}");

        installation(InstallationMode.BUILD).action(ActionType.INSTALL_PACKAGE,
                "packages/${project.artifactId}-package-${project.version}.package");

        finderDatasource(VenafiTPMPluginAdaptor.class, DATASOURCE).anonymousLogin(LoginMode.INTERNAL);
    }
}
