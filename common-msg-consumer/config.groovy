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
