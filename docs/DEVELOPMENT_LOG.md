# Development Log

## 2026-11-20 — Phase 1 foundation

- Confirmed product direction: WebView is the primary playback engine; Media3 is reserved
  as an optional native playback fallback.
- Initial target scope: official Chinese television live-stream webpages.
- Inspected the repository: it contained only the initial README and .gitignore.
- Created the `develop` branch from `main`.
- Added the initial Android/Kotlin Gradle project, Android TV manifest, WebView host,
  local startup page, Media3 dependency reservation, and CI workflow.
- Status: awaiting CI/build verification and user installation testing.
- No stable tag or release has been created.

## 2026-11-20 — Homepage prototype 0.1

- Replaced the placeholder startup page with the first Android TV homepage prototype.
- Added province grid, search, expandable full province list and adaptive channel-card grid.
- Added keyboard/D-pad focus movement within the province and channel areas.
- Province selection only changes the displayed channel area; it does not launch playback.
- Added an empty state for provinces without confirmed channel data.
- Added confirmed sample channel names for Hebei, Shanxi and Shanghai only.
- Used neutral TV placeholders; no fabricated station logos or unverified live URLs.
- Removed favorites and recent-play features from the homepage.
- Status: code committed to `develop`; visual, D-pad, build and device tests are still pending.
- This is a development prototype, not a stable release.
