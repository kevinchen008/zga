environments {
    dev {
        jdbc {
            driverClassName='com.mysql.jdbc.Driver'
            username='root'
            password='123456'
            url='jdbc:mysql://localhost:3306/zga'
            pool.init=1
            pool.minIdle=3
            pool.maxActive=50
            testSql="SELECT 'x'"
        }
        redis {
            host='172.19.50.100'
            port=6379
            password=''
        }
        pay {
            unionPay {
                acpsdk {
                    //交易请求地址
                    frontTransUrl='https://gateway.test.95516.com/gateway/api/frontTransReq.do'
                    //报文版本号，固定5.1.0，请勿改动
                    version='5.1.0'
                    //签名方式，证书方式固定01，请勿改动
                    signMethod='01'
                    //商户号
                    merId='777290058156142'
                    //字符集编码，可以使用UTF-8,GBK两种方式
                    encoding='UTF-8'
                    //交易类型 ，01：消费
                    txnType='01'
                    //交易子类型， 01：自助消费
                    txnSubType='01'
                    //业务类型，B2C网关支付，手机wap支付
                    bizType='000201'
                    //渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板  08：手机
                    channelType='07'
                    //接入类型，0：直连商户
                    accessType='0'
                    //交易币种（境内商户一般是156 人民币）
                    currencyCode='156'
                    //后台通知地址，填写接收银联后台通知的地址，必须外网能访问
                    backUrl='http://222.222.222.222:8080/ACPSample_B2C/backRcvResponse'
                    //前台通知地址，填写处理银联前台通知的地址，必须外网能访问
                    frontUrl='http://localhost:8080/ACPSample_B2C/frontRcvResponse'
                    //签名证书路径，测试证书所有商户共用开发包中的测试签名证书，生产环境请从cfca下载得到。
                    signCertPath='D:/certs/acp_test_sign.pfx'
                    //签名证书密码，测试环境固定000000，生产环境请修改为从cfca下载的正式证书的密码，正式环境证书密码位数需小于等于6位，否则上传到商户服务网站会失败
                    signCertPwd=000000
                    //签名证书类型，固定不需要修改
                    signCertType=PKCS12
                    //敏感信息加密证书路径(商户号开通了商户对敏感信息加密的权限，需要对 卡号accNo，pin和phoneNo，cvn2，expired加密（如果这些上送的话），对敏感信息加密使用)
                    encryptCertPath='D:/certs/acp_test_enc.cer'
                    //验签中级证书路径(银联提供)
                    middleCertPath='D:/certs/acp_test_middle.cer'
                    //验签根证书路径(银联提供)
                    rootCertPath='D:/certs/acp_test_root.cer'
                }
            }
        }
    }
    test {
        jdbc {
            driverClassName='com.mysql.jdbc.Driver'
            username='root'
            password='123456'
            url='jdbc:mysql://localhost:3306/zga'
            pool.init=1
            pool.minIdle=3
            pool.maxActive=50
            testSql="SELECT 'x'"
        }
        redis {
            host='172.19.50.100'
            port=6379
            password=''
        }
    }

    uat {
        jdbc {
            driverClassName='com.mysql.jdbc.Driver'
            username='root'
            password='123456'
            url='jdbc:mysql://localhost:3306/zga'
            pool.init=1
            pool.minIdle=3
            pool.maxActive=50
            testSql="SELECT 'x'"
        }
        redis {
            host='172.19.50.100'
            port=6379
            password=''
        }
    }

    prod {
        jdbc {
            driverClassName='com.mysql.jdbc.Driver'
            username='root'
            password='123456'
            url='jdbc:mysql://localhost:3306/zga'
            pool.init=1
            pool.minIdle=3
            pool.maxActive=50
            testSql="SELECT 'x'"
        }
        redis {
            host='172.19.50.100'
            port=6379
            password=''
        }
    }
}
/*



printf 'Learn Groovy for gradle basic!'

*/
/*单引号字符串是java.lang.String类型的，不支持站位符插值操作，*//*

def name = 'test Groovy!'
def body ='test $name'

assert name == 'test Groovy!'
assert body == 'test $name'

def name1 ='kevin'
def greeting = "Hello ${name1}"
assert greeting.toString() == 'Hello kevin'

def sum = "ths sum0f 2 and 3 equals ${2+3}"
assert sum.toString() =='ths sum0f 2 and 3 equals 5'

def person = [name:'kevin',age:29]
assert "$person.name is $person.age years old"=="kevin is 29 years old"

*/
