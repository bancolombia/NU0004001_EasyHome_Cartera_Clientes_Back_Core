package co.com.bancolombia.easyhome.clientes.core.loansMortgages;

import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessExeptionType;
import co.com.bancolombia.easyhome.clientes.core.gateways.SessionIdGateway;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ConsumeSessionIdAdapter implements SessionIdGateway {

    @Value("${url.session}")
    private String url;
    @Value("${validSession}")
    private String validSession;
    @Value("${statusSession}")
    private String statusSession;
    private final OkHttpClient client;
    private final TechLogger techLogger;

    @Override
    public boolean sessionIdValid(String customerIdType, String customerId, String sessionToken) {
        boolean sessionValid = false;
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cookie", String.format("token=%s", sessionToken))
                .addHeader("Cookie", String.format("documentNumber=%s", customerId))
                .addHeader("Cookie", String.format("documentType=%s", customerIdType))
                .get()
                .build();
        Response response = null;
        System.out.println(request);
        try {
            response = client.newCall(request).execute();
            String responseStr = response.body().string();
            JSONObject jsonResponse = new JSONObject(responseStr);
            String value = jsonResponse.getString(statusSession);
            if (value.equals(validSession)) {
                sessionValid = true;
            }
        } catch (JSONException | IOException je) {
        techLogger.error(BusinessExeptionType.COR08);
        throw new BusinessException(BusinessExeptionType.COR08);
    }

        return sessionValid;
    }
}