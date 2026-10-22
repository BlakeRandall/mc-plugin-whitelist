package dev.example.whitelistbypass;

final class WhitelistBypassPolicy {

    private WhitelistBypassPolicy() {
    }

    static boolean shouldGrant(
            boolean alreadyWhitelisted,
            boolean operator,
            boolean hasBypassPermission
    ) {
        return !alreadyWhitelisted
                && (operator || hasBypassPermission);
    }
}