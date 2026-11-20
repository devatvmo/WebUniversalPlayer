# WebUniversalPlayer

面向 Android TV 的通用网页直播播放器。项目以 Android WebView 为主播放引擎，并预留 AndroidX Media3 作为后续可选的原生播放辅助引擎。

> 当前状态：Phase 1 — Android 工程基础建设。当前版本为 `0.1.0-alpha.1`，尚未经过用户设备验收，不是稳定版。

## 项目目标

- 面向 Android TV，适配十字方向键遥控器。
- 通过 WebView 加载国内电视台官方直播网页，尽可能保留网站原生播放器能力。
- 通过网站适配器处理不同网站的页面结构与播放器差异。
- 自动识别网页中的频道信息。
- 使用统一播放调度器管理加载、切台与播放状态。
- 支持网页播放器全屏，并在后续阶段完善焦点和返回键行为。

网页是否能够播放取决于网站自身访问策略、视频技术、DRM、登录状态及设备 WebView 能力；不承诺所有网站均可播放。

## 技术选型

- Kotlin
- Android Gradle Plugin 8.7.3
- Kotlin Android Plugin 2.0.21
- Android SDK：compile/target 35，min 23
- Android WebView
- AndroidX Media3 ExoPlayer（已加入依赖，后续作为可选辅助引擎接入）

## 当前工程结构

```text
app/
  src/main/
    java/com/webuniversalplayer/   # Android 应用入口与 WebView 宿主
    assets/                        # 本地启动页
    res/                           # Android TV 资源
  src/test/                        # 单元测试
docs/
  DEVELOPMENT_LOG.md
  TESTING.md
  VERSIONING.md
CHANGELOG.md
```

后续将按职责逐步增加 `ui`、`webview`、`adapter`、`detector`、`scheduler`、`remote`、`fullscreen`、`storage` 等模块。

## 构建

需要 JDK 17、Android SDK 35 和 Gradle 8.9。

```bash
gradle :app:testDebugUnitTest :app:assembleDebug
```

Debug APK 输出位置：

`app/build/outputs/apk/debug/app-debug.apk`

GitHub Actions 会在 `main` / `develop` 分支 push、Pull Request 和手动触发时执行构建及单元测试。

## 开发流程与版本

- `main`：保留经用户验收的稳定里程碑。
- `develop`：日常开发分支。
- 遵循语义化版本号；开发期使用 alpha/beta/rc 预发布标识。
- 变更记录见 [CHANGELOG](CHANGELOG.md)。
- 开发过程见 [开发记录](docs/DEVELOPMENT_LOG.md)。
- 测试清单见 [测试记录](docs/TESTING.md)。
- 版本规则见 [版本管理](docs/VERSIONING.md)。

未经用户实际测试并明确确认，不创建正式稳定版标签或 GitHub Release。
