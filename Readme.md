# OnePlayerSleep
这是一个Minecraft服务器插件，指定一个百分比，同一个世界中睡眠玩家数量 >= 玩家总数 * 百分比，即跳过黑夜。可设置一人眠模式，该模式下无论服务器中有多少人，只需要一个人睡觉，即可跳过黑夜。

![游戏内截图](https://picture.haaland.top:81/images/2023/12/31/IMG_20231231_122728.png)

## 服务端
基于Paper，支持Spigot

## 游戏版本
1.16.5 及以上

## 配置文件
```yaml
# 是否重写进入服务器的提示消息
enter-message-rewrite: false

# 入睡时间，玩家上床后多久时间进行判定，单位为服务器Tick，正常情况下为20 ticks/s
fall-asleep-time: 60

# 是否启用检测睡眠
enabled: true

# 百分比设置，在同一个世界中睡眠玩家数量 >= 玩家总数*百分比，即跳过黑夜
skip-percent: 50

# 是否启用一人眠模式，该模式忽略百分比设置，一人睡觉即可跳过黑夜
one-player-mode: false
```

## 指令和权限
本插件暂时未设置指令和权限系统，功能较基础，期待你的Issue和PR。