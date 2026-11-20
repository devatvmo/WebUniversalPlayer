# Testing

## Phase 1 — Android project foundation

### Automated checks

- [ ] GitHub Actions Gradle build succeeds.
- [ ] Debug APK is generated.

### Manual checks

- [ ] Install the debug APK on an Android TV device or emulator.
- [ ] App appears in the TV launcher.
- [ ] App opens in landscape orientation.
- [ ] Startup page is displayed without crashing.
- [ ] Back exits the app cleanly.

## Homepage prototype — 0.1

### Visual layout

- [ ] Homepage fills a 16:9 TV screen without unintended page-level scrolling.
- [ ] Header shows only Home and Settings; no Favorites or Recent Plays.
- [ ] Province grid displays correctly at 1080p and 720p.
- [ ] More/Collapse reveals the complete province list.
- [ ] Province search filters the grid correctly.
- [ ] Channel grid adapts to different channel counts and long channel names.
- [ ] Uncollected provinces show an empty-state message.
- [ ] Placeholder marks are used until official station logos are verified.

### Remote-control navigation

- [ ] D-pad moves focus predictably inside the province grid.
- [ ] Selecting a province updates channels without starting playback.
- [ ] D-pad moves focus predictably inside the channel grid.
- [ ] Up from the first channel row returns focus to the selected province.
- [ ] Down from the province grid enters the channel area without activating a channel.
- [ ] OK on a prototype channel shows the not-yet-connected notice.
- [ ] Back returns focus from channel area to province selection.
- [ ] Settings dialog opens, closes and restores focus.

### Not included in this prototype

- Live website playback and channel switching.
- Verified official station logo assets.
- Persistent preferences and settings.
- Final accessibility and device-specific focus tuning.

Record device model, Android version, test result and issues below after each user test.
