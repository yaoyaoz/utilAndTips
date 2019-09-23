// QServiceEasy-data.thrift
namespace java xq.foundation.thrift

// struct关键字用于定义结构体，相当于面向对象编程语言中的类
struct ThriftCmdStruct {
    // 相当于定义类中的成员，并生成相应的get和set方法，optional表示username这个成员可以没有
    1: binary imgA,
    2: binary imgB,
    3: binary featureA,
    4: binary featureB,
    5: string param
}

struct ThriftResultStrcut {
	1: i32 result,
	2: string info
	3: string data
	4: binary ext
}

// 定义服务接口
service ThriftService {
    ThriftResultStrcut doProcess(1: string cmd, 2: string seq, 3: ThriftCmdStruct body)
}
