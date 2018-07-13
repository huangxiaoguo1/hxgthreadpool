"# hxgthreadpool" 

### 使用方法
```
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    
    dependencies {
    
        implementation 'com.github.huangxiaoguo1:hxgthreadpool:1.0.0'
    }
```
#### 创建子线程

```
  子线程执行  给联网 ... 特别耗时的 操作使用
   
  ThreadUtils.runOnLongBackThread(new Runnable() {
       @Override
       public void run() {
            Log.e("huangxiaoguo", "huangxiaoguo--runOnLongBackThread-" + m);
          SystemClock.sleep(2000);
       }
   });   
                  
                  
   子线程执行   给相对联网  耗时少的操作使用
                  
    ThreadUtils.runOnShortBackThread(new Runnable() {
         @Override
         public void run() {
            Log.e("huangxiaoguo", "huangxiaoguo--runOnShortBackThread-" + m);
            SystemClock.sleep(2000);
         }
      });   
                 
      
```

###### 取消线程


```
 ThreadUtils.cancelLongBackThread();
 
 ThreadUtils.cancelShortThread();
```