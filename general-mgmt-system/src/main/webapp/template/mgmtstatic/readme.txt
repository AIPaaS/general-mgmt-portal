如何获取最新模板？
请修改build.gradle，在合适位置增加
apply plugin: "APIJarProcess"
configurations {
    optUedTemplate
}

buildscript {
    repositories {
       maven { url "http://10.1.228.199:18081/nexus/content/groups/public/" }
    }
    dependencies {
        classpath group: 'com.ai.runner.plugin', name: 'apijarprocessplugin', version: '1.0'
    }
}

dependencies {
	optUedTemplate 'com.ai.opt.uniframe:opt-ued-template:1.0-SNAPSHOT'
	.....其它配置
}

def getUedTemplate=task("getUedTemplate",type:com.ai.runner.gradle.plugin.jar.APIJarProcessTask){
	jarPaths=configurations.optUedTemplate.files.asType(List)
    destinationDir file("src/main/webapp/resources/template") //这里面的路径建议保持默认
}

配置好上述脚本后，请在IDE插件或者在命令行执行
gradle getUedTemplate 


