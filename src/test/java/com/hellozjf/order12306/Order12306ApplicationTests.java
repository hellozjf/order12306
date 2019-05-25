package com.hellozjf.order12306;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hellozjf.order12306.constants.UriEnum;
import com.hellozjf.order12306.dto.OtnIndex12306GetLoginBannerDataDTO;
import com.hellozjf.order12306.dto.OtnLoginConfDataDTO;
import com.hellozjf.order12306.dto.ResultNormalDTO;
import com.hellozjf.order12306.dto.ResultUamtkStaticDTO;
import com.hellozjf.order12306.service.CookieService;
import com.hellozjf.order12306.service.SendService;
import com.hellozjf.order12306.service.UriService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.CookieManager;
import java.net.http.HttpClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Order12306ApplicationTests {

    private HttpClient httpClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SendService sendService;

    @Autowired
    private UriService uriService;

    @Autowired
    private CookieService cookieService;

    @Test
    public void contextLoads() {
    }

    @Before
    public void before() {
        CookieManager cookieManager = new CookieManager();
        this.httpClient = HttpClient.newBuilder()
                .cookieHandler(cookieManager)
                .build();
    }

    @Test
    public void otnLoginConf() throws JsonProcessingException {
        ResultNormalDTO<OtnLoginConfDataDTO> resultNormalDTO =
                sendService.send(httpClient,
                        UriEnum.OTN_LOGIN_CONF,
                        "",
                        new TypeReference<ResultNormalDTO<OtnLoginConfDataDTO>>(){});
        log.debug("result = {}",
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultNormalDTO));
    }

    @Test
    public void otnIndex12306GetLoginBanner() throws JsonProcessingException {
        ResultNormalDTO<OtnIndex12306GetLoginBannerDataDTO> resultNormalDTO =
                sendService.send(httpClient,
                        UriEnum.OTN_INDEX12306_GETLOGINBANNER,
                        "",
                        new TypeReference<ResultNormalDTO<OtnIndex12306GetLoginBannerDataDTO>>(){});
        log.debug("result = {}",
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultNormalDTO));
    }

    @Test
    public void passportWebAuthUamtkStatic() throws JsonProcessingException {

        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "8888");

        ResultUamtkStaticDTO resultUamtkStaticDTO =
                sendService.send(httpClient,
                        UriEnum.PASSPORT_WEB_AUTH_UAMTK_STATIC,
                        "appid=otn",
                        new TypeReference<ResultUamtkStaticDTO>(){});
        log.debug("result = {}",
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultUamtkStaticDTO));
    }

}
