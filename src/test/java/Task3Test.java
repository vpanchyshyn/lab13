import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task3.BrandFetchReader;
import ua.edu.ucu.apps.task3.Company;
import ua.edu.ucu.apps.task3.CompanyReaderFacade;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Task3Test {

    @Test
    public void testBrandFetchReader() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(BrandFetchReader.BRAND_FETCH_URL + "ucu.edu.ua"))
                .header("Authorization", "Bearer " + BrandFetchReader.API_KEY)
                .build();
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.body()).thenReturn("{\"name\": \"UCU\"}");
        when(mockClient.send(eq(request), any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        BrandFetchReader brandFetchReader = new BrandFetchReader();
        Company company = brandFetchReader.fetch("ucu.edu.ua");

        assertNotNull(company);
        System.out.println(company);
    }

    @Test
    public void testCompanyReaderFacade() {
        CompanyReaderFacade companyReaderFacade = new CompanyReaderFacade();
        Company company = companyReaderFacade.fetch("ucu.edu.ua");

        assertNotNull(company);
        System.out.println(company);
    }
}
