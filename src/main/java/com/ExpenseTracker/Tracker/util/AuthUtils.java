package com.ExpenseTracker.Tracker.util;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public final class AuthUtils {

    private AuthUtils() {}

    public static String currentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new AccessDeniedException("Unauthenticated");
        }
        Object principal = auth.getPrincipal();
        return principal instanceof UserDetails
                ? ((UserDetails) principal).getUsername()
                : principal.toString();
    }
}
