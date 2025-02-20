# OnePlayerSleep

## 备注
> !! 本插件为作者结合个人服务器需要，学习插件编写过程中的产物，实用性暂时有限。
> 
> 游戏中可输入指令`/gamerule playersSleepingPercentage <value>` 来达到与本插件基本功能类似的效果
> 
> value 可以设置 0 - 100 之间的百分比值（默认值：100）。
> 
> 例如，将此值设置为 50 意味着一半的玩家需要睡觉才能跳过夜晚。若需要1人睡觉跳过黑夜，则将此值设置为 1即可。
> 
> 因此本插件暂时不再更新，若有优化原版体验的相关建议，可在issue中提出。

## 基本介绍

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

# 是否在睡眠的同时把天气改为晴朗，默认关闭
change-weather: false

# 晴朗天气持续时间，相当于/weather clear xxx，单位为tick
clear-weather-time: 10000
```

## 指令和权限
本插件暂时未设置指令和权限系统，功能较基础，期待你的Issue和PR。