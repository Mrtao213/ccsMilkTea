package com.example.demo_teamanage;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.demo_teamanage.mapper")
public class DemoTeaManageApplication {

    public static void main(String[] args) {
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(getOptions());

        SpringApplication.run(DemoTeaManageApplication.class, args);
    }
    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi-sandbox.dl.alipaydev.com/gateway.do";
        config.signType = "RSA2";
        config.appId = "9021000141617562";
        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDBV2OjNvYGvpMa4hz8n8/NngkJ6E+C0GGOe3T2ONWt1q+nD5z9J8vzNopjnNI91nVXcRjfBaEweQJsrQXtujvyF+qKKtufbtR4uk2CLkjYMmfnJCxthsGdgS1RRutXnb+rP0fmi4jIpFt26le8PRo1QcPxkS3Lg/DTqGh6hEkFmJdJOUF0wFWyYd7sn1PjCbdn9iEjCCmrUyQNjUEiaQQgnZIZ+hFNf/9q38uv8spmm/oMa7isW4kBjUx7y4/bBkCtCV3ta6HJbGvVqMtwmjW13jJHdeMKJH7v1ko/e6qssTy2Gsf3ATKnZMcquxwnztkWkBHLMuauuq6OJxrJIyvTAgMBAAECggEAZ8Umtkhefjo1LF2mHzULTJoA0e99FYIQim/a0/inP1mWB32KzhlZDt38IwDdmtELQ/Zw2erkm+anFXs8Tl8Bo6uQd74PCKBsq6uaxD9hW6CaQeYZbmPAcXAOyavdzrXdVOVvCt9jeAU3DjkzA9ZrxZ/ZskMwqCXV0VR3VyK/Kp/Pmmvf085tAgGLI8P8Qs1d5rG+l1ITOjWrvO5JheM8TqXbGCjyPTapopnihdU+DV4NDXkd+KjOfoGGR1J7s2kbYCGcyg3una5JlK20E3jRBzTxMziCmI95/1dxKw82z0uRuf4Cf5ewhaTEgS2oXNqy7hFxfw+i8cNtF6jGhIWvaQKBgQDqHPub81Gxf+WO9sr69QysW/4oV8mfXRIIQ4unrCFdst49Ebm7xVT0GZZDJ2Nb27vmMS5ptqblJ0gxgzgdCIG7PFQfpYm3Ziu+xG2y8fmPPtRsqtkgqePyx06eFolaTTsuiz6NYwrAZz8eqIC4iFmXmC9VcsPP08/pE86FLTiZRQKBgQDTap299i6vQafvW8b/4PxNjxq25j2NwrdJk8VsKcMH5wSN2cRfw3KDpfnw/ORScCZuD+avBbnT/IFJsF3NkFzsfHvUGyH6X2608xOSOxFO9nH7LQedXC7qlyEDmagStfpf5sFxTaoDU2NDuYvTKt96ceTAre0qC0an6D5EKPImNwKBgQDCLePrx/ecd+6Zk81sNdCbLXozUA0lp3aLcCrnmffa1b9Le+ZH/jameIqPjJ321NyW43gRqrPnIZvZpXLnceTYvgMwdIcznQTvp9EtOVK7I2vh7htF4mP1PKbSrPKj+ab6xffOIbYLPBe4gB6z8DQPbuTjxNrxCEhMlGcZQxbM2QKBgQCTfEIU3iPNQTk9QsI9iR+Zn6ZcR5xTQ64Hlx3Xif6ziZbkujFDOR6u9l+5nUJOvEwi5dbg7FapqvIqjO2zVO1uUJ0158O5XU/mzdguYCR/+G6lcdFpFoDoSIvQbiYQ/4Bt3JXATBS5gzexbEQ+CR+j1MZnIC5d8UXWJq8hb4sV2wKBgQC614aYqgy7o5AtqgTxUhGiqSmud+4bcUPUXhhVmP8mbqTqvXSZhQm/PF2NeuyhQTb7t42YTnWS8YgdEooSGOqSCgUKvijSs58Qwa99X5dbUwFLyTGwRQqscr+33lXi7gxmsexXH8HwEjMxnJe8LTM+trBomtzgw3SFnQrjHzivdw==";
        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
         config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAstLr8eAvo1OBcxwu9fxp/MVMRXOgnU2gU2xzwWCkthMsQGOWbxG7nn4i6yzp17k46eOE5nvvJiLxBPl6f+fRCe5oKkoGJIGrGos4qs+ibvXWjNofFZWhGNt9kZ7+4IIJ4CHhRLv+iJC7/AYS20K+D9OJLzi10w2R17C3+GPoavk5rhQeXd23JsBi/ly/P7Hrmg6yNP+4UK16M52kH9Dn57td1S1FPk7Z6ABiBRbGgH8vccJiLNN3wwKw/s/4aQynrl7prFz7cv419nwXJUIUEtG0OiK/XS7Zzrh5MRzbU67KYFJD44LBkQlJwHLAUi3OTZKq+Y84TP1NlQM0ugbm+QIDAQAB";
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "http://bjt5ve.natappfree.cc/alipay/notify";
        return config;
    }

}
