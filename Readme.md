# OnePlayerSleep
这是一个Minecraft服务器插件，无论服务器中有多少人，只需要一个人睡觉，即可跳过黑夜。

## 服务端
基于Paper，支持Spigot

## 游戏版本
1.16.5 及以上

## 配置文件
```yaml
# 是否重写进入服务器的提示消息
enter-message-rewrite: false

# 入睡时间，单位为服务器Tick，正常情况下为20 ticks/s
fall-asleep-time: 60

# 是否启用检测睡眠
enabled: true
```

## 指令和权限
本插件暂时未设置指令和权限系统，功能较基础，期待你的Issue和PR。