# Changelog

All notable changes to this project are documented in this file.

The project currently uses the `0.y.z` development version series. No stable release
has been declared. A stable release requires explicit user testing and confirmation.

## [Unreleased]

### Added

- Initial Android/Kotlin application module targeting Android TV.
- WebView host activity and local startup page.
- Basic HTML5 fullscreen custom-view handling.
- Android TV launcher intent, landscape orientation and touchless-device declarations.
- AndroidX Media3 ExoPlayer dependency reserved for a future optional native fallback.
- GitHub Actions workflow for debug build and unit tests.
- Development, testing and versioning documentation.
- First TV homepage layout with province search, expandable province grid and adaptive channel cards.
- D-pad focus navigation for province and channel grids; selecting a province does not start playback.
- Empty-state messaging for regions whose official channel lists are not yet collected.
- Text-based placeholder marks until verified official station logos are available.

### Notes

- This homepage is a UI prototype. Channel playback links, verified logos, persistent settings
  and the dedicated live-player screen are not connected yet.
