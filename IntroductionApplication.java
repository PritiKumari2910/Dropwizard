import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;

public class IntroductionApplication extends Application<BasicConfiguration> {

    public static void main(String[] args) throws Exception {
        new IntroductionApplication().run("server", "introduction-config.yml");
    }

    @Override
    public void run(BasicConfiguration basicConfiguration, Environment environment) {
        System.out.println("Inside run");
        int defaultSize = basicConfiguration.getDefaultSize();
        BrandRepository brandRepository = new BrandRepository(initBrands());
        BrandResource brandResource = new BrandResource(defaultSize, brandRepository);

        environment
                .jersey()
                .register(brandResource);
    }

    private List<Brand> initBrands() {
        Brand brand1 = new Brand(new Long(1),"Puma");
        Brand brand2 = new Brand(new Long(2),"Addidas");
        Brand brand3 = new Brand(new Long(3),"Reebok");
        List<Brand> lb = new ArrayList<>();
        lb.add(brand1);
        lb.add(brand2);
        lb.add(brand3);
        return lb;

    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }
}
