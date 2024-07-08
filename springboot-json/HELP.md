JSON 处理

三大主流框架

- jackson
- gson
- fastjosn

SpringMvc 框架中，jackson和gosn已经自动配置好了,也就是 HttpMessageConvert 自动配置好了
fastjosn则需要开发者手动配置 HttpMessageConvert

序列化：对象->JSON （响应JSON）

反序列化：JSON->对象 （请求参数是 JSON）

HttpMessageConvert:

转换器：对象->JSON，JSON->对象

这是个接口，所有的JSON工具都会提供各自的 HttpMessageConvert
- jackson  MappingJackson2HttpMessageConverter
- gson   GsonHttpMessageConverter
- fastjosn

ObjectMapper jackson提供的手动解析json的，MappingJackson2HttpMessageConverter也是调用了他

gson 是Gson

