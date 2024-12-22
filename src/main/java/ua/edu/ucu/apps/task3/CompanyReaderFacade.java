package ua.edu.ucu.apps.task3;

public class CompanyReaderFacade {

    private BrandFetchReader brandFetchReader;

    public CompanyReaderFacade() {
        this.brandFetchReader = new BrandFetchReader();
    }

    public Company fetch(String companyName) {
        Company companyBF = brandFetchReader.fetch(companyName);
        return companyBF;
    }
}
