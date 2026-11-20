# Versioning Policy

- Follow Semantic Versioning: MAJOR.MINOR.PATCH.
- During initial development, use prerelease identifiers such as
  `0.1.0-alpha.1`, `0.1.0-beta.1`, and `0.1.0-rc.1`.
- Increment `versionCode` for every distributed Android build.
- Record user-visible changes in `CHANGELOG.md`.
- Record implementation decisions and milestones in `docs/DEVELOPMENT_LOG.md`.
- Record test coverage and results in `docs/TESTING.md`.
- Do not create a stable Git tag or GitHub Release until the user has tested and
  explicitly approved the release.
- Keep `main` reserved for user-approved stable milestones; do active development
  on `develop`.
