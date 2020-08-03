# encodecons
## features
加密项目中的字符串
## use
``` groovy
//build.gradle
android {
    //...
    
    defaultConfig {
        //...
        buildConfigField "String", "STR_1", "\"" + encrypt(KEY, "这是个需要加密的字符串") + "\""
    }
}
```
``` java
class YourClass {
    private static final String STR_1 = VarUtils.decrypt(BuildConfig.STR_1);
}
```