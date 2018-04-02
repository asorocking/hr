
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import java.io.*;
import java.net.URLEncoder;
public class HttpClientTest {
    private static final String DOMAIN = "localhost";
    private static final String SITE_ROOT = "http://" + DOMAIN + "/";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String SITE_CHARSET = "CP1251";
    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset(DEFAULT_CHARSET);
        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        HttpState state = new HttpState();
        state.addCookie(new Cookie(DOMAIN, "name", "Platon", "/forum/", new Date(System.currentTimeMillis() + 3600*1000*24*365L), false));
        state.addCookie(new Cookie(DOMAIN, "password", "******", "/forum/", new Date(System.currentTimeMillis() + 3600*1000*24*365L), false));
         httpClient.setState(state);
        // Загрузка страницы с запросом методом GET
        GetMethod getMethod = new GetMethod(SITE_ROOT + "index.html?cat=1&amp;search=" + URLEncoder.encode("Доктор Хаус", SITE_CHARSET));
        getMethod.getParams().setContentCharset(SITE_CHARSET);
        try {
            int result = httpClient.executeMethod(getMethod);
            if (result == HttpStatus.SC_OK) {
                // Выводим страницу на экран
                System.out.println(getMethod.getResponseBodyAsString());
            } else {
                System.out.println("А страничка-то и не загрузилась!!!");
                return;
            }
        } catch (IOException e) {
            System.out.println("Проблемы со связью");
            return;
        } finally {
            getMethod.releaseConnection();
        }
        // Загрузка страницы с запросом методом POST
        PostMethod postMethod = new PostMethod(SITE_ROOT + "index.html");
        postMethod.addParameter("cat", "1");
        postMethod.addParameter("name", "Доктор Хаус");
        postMethod.getParams().setContentCharset(SITE_CHARSET);
        try {
            int result = httpClient.executeMethod(postMethod);
            if (result == HttpStatus.SC_OK) {
                // Выводим страницу на экран
                printStream(postMethod.getResponseBodyAsStream());
            } else {
                System.out.println("А страничка-то и не загрузилась!!!");
                return;
            }
        } catch (IOException e) {
            System.out.println("Проблемы со связью");
            return;
        } finally {
            postMethod.releaseConnection();
        }
    }
    private static void printStream(InputStream res) throws IOException {
        InputStreamReader reader = new InputStreamReader(res, SITE_CHARSET);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        int am;
        char[] buffer = new char[4096];
        while ((am = reader.read(buffer)) != -1)
            writer.write(buffer, 0, am);
    }
}