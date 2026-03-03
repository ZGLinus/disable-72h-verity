# Disable72hVerify

[![AGPL-3.0 License](https://img.shields.io/badge/license-AGPL--3.0-blue.svg)](LICENSE)
[![Xposed](https://img.shields.io/badge/Xposed-API%2082-green.svg)](https://repo1.maven.org/maven2/de/robv/android/xposed/api/82/)
[![Status](https://img.shields.io/badge/status-pre--release-orange)]()

一个轻量级 **Xposed 模块**，用于**禁用 Android 系统每 72 小时强制输入锁屏密码**的限制，保留指纹/面部等生物识别解锁的便利性。

> ⚠️ **项目状态：预发行（Pre-release）**  
> 当前版本处于早期测试阶段，可能存在未知问题，请谨慎使用。所有发布版本均为预发行版，请从 [Releases](https://github.com/zglinus/disable-72h-verity/releases) 页面下载。

---

## ✨ 功能

- 拦截系统服务 `android.app.admin.DevicePolicyManager.getRequiredStrongAuthTimeout` 方法，修改返回值为1年而不是3天。
- 完全移除 72 小时强制密码验证，但**不会移除或禁用已有的锁屏密码**，安全性不受影响。
- 提供简洁的状态界面，实时显示 Hook 是否生效。
- 项目结构图
```
com.zglinus.disable72hverify/
├── app/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── assets/
│           │   └── xposed_init
│           ├── java/
│           │   └── com/
│           │       └── zglinus/
│           │           └── disable72hverify/
│           │               ├── XposedInit.java
│           │               ├── SystemPropertiesHelper.java
│           │               └── StatusActivity.java
│           └── res/
│               ├── layout/
│               │   └── activity_status.xml
│               └── values/
│                   └── strings.xml
└── settings.gradle
```

---

## 📱 最低环境要求

| 项目 | 最低要求 |
|------|----------|
| **Android 版本** | 8.0 (API 26) |
| **Xposed 框架** | 官方原版 Xposed (rovo89) 版本 82 或更高 |
| **Root 要求** | 需安装 Xposed 框架并激活模块 |

> **注意**：本模块**仅测试过官方原版 Xposed (rovo89)**，LSPosed、EdXposed、TaiChi 等其他框架**未经验证，不保证生效**。如使用其他框架请自行测试。

---

## 🔧 安装与使用

### 前置条件
- 手机已解锁 Bootloader 并获取 Root 权限
- 已安装 [Xposed Installer](https://forum.xda-developers.com/showthread.php?t=3034811) 并刷入对应 Android 8.0/8.1 的官方框架

### 步骤
1. 从 [Releases](https://github.com/zglinus/disable-72h-verity/releases) 页面下载最新 APK。
2. 安装 APK。
3. 打开 Xposed Installer → **模块**，勾选 `Disable72hVerify`。
4. **重启手机**（必须重启使模块加载）。
5. 打开桌面应用图标，进入状态界面确认 Hook 是否生效。

> 💡 若状态显示 **“✅ Hook 已生效”**，则说明模块工作正常。

---

## 📄 许可证

本项目基于 **GNU Affero General Public License v3.0 (AGPL-3.0)** 开源。  
完整协议请查看 [LICENSE](LICENSE) 文件。

---

## 🙏 致谢

- **[XposedBridge](https://repo1.maven.org/maven2/de/robv/android/xposed/)** – 强大的 Xposed 框架 API。
- 代码生成辅助：[DeepSeek](https://deepseek.com/) – 部分实现由 AI 协助完成。

---

## ⚠️ 免责声明

- 本模块**仅供学习研究**，请勿用于非法用途。
- 使用本模块导致的任何数据丢失、系统不稳定或安全风险，开发者概不负责。
- 如您修改并重新分发，请遵守 AGPL-3.0 协议要求开放源代码。

---

## 🐛 反馈与贡献

- 问题反馈请提交 [Issues](https://github.com/zglinus/disable-72h-verity/issues)
- 欢迎 Pull Request，但请确保代码风格一致并遵循 AGPL-3.0 协议。

---

**Happy Hooking!** 🔧
