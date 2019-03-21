## 注意点
1. pojo作为参数在xml中取得时候只需要#{属性名}就可以取到pojo的值。
2. map作为参数在xml中取得时候需要取#{map的key值}。
3. 返回一个List<Object>的时候resultType就写单个Object的内容。
4. 将数据返回以map的形式，格式为{zhukey={key=value, ...}, ...}, xmlresultType为map，mapper接口需要指定MapKey作为zhukey

