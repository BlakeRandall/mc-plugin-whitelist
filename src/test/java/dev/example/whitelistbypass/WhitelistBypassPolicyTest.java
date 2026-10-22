package dev.example.whitelistbypass;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class WhitelistBypassPolicyTest {

    @Test
    void doesNotGrantBypassToAlreadyWhitelistedPlayers() {
        assertFalse(WhitelistBypassPolicy.shouldGrant(true, false, false));
    }

    @Test
    void grantsBypassToOperatorsWithoutThePermission() {
        assertTrue(WhitelistBypassPolicy.shouldGrant(false, true, false));
    }

    @Test
    void grantsBypassToPlayersWithThePermission() {
        assertTrue(WhitelistBypassPolicy.shouldGrant(false, false, true));
    }

    @Test
    void deniesBypassWhenPlayerLacksThePermission() {
        assertFalse(WhitelistBypassPolicy.shouldGrant(false, false, false));
    }
}