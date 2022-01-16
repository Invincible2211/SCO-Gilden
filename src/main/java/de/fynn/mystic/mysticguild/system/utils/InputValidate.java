package de.fynn.mystic.mysticguild.system.utils;

import de.fynn.mystic.mysticguild.community.alianz.AlianzManager;
import de.fynn.mystic.mysticguild.community.guild.GuildManager;

/**
 * @author Freddyblitz
 */

public class InputValidate {

    private static final GuildManager guildManager = GuildManager.getInstance();
    private static final AlianzManager alianzManager = AlianzManager.getInstance();

    /**
     * checks if the given String only contains a...z,A...Z
     * @param input the string that is checked
     * @return true if only allowed characters are used
     */
    public static boolean defaultValidation(String input){
        int state = 0;
        for (Character c:
             input.toLowerCase().toCharArray()) {
            switch (state){
                case 0:
                    state = c <= 'z' && c >= 'a' ? 1 : 2;
                    break;
                case 1:
                    break;
            }
        }
        return state == 0 && input.length()>=4;
    }

    /**
     * checks if the given string corresponds to an existing guild role and does a default validation
     * @param input the string that has to be checked
     * @param guild the guild whose roles are to be used as a reference for the check
     * @return true if no role with this specific name exists and the default validation was also successful
     */
    public static boolean validateRoleNameGuild(String input, String guild){
        return !guildManager.containsRole(guild,input) && defaultValidation(input);
    }

    /**
     * checks if the given string corresponds to an existing alianz role and does a default validation
     * @param input the string that has to be checked
     * @param alianz the alianz whose roles are to be used as a reference for the check
     * @return true if no role with this specific name exists and the default validation was also successful
     */
    public static boolean validateRoleNameAlianz(String input, String alianz){
        return !alianzManager.containsRole(alianz,input) && defaultValidation(input);
    }

    /**
     * checks if the given string contains between 3 and 8 characters and does a default validation
     * @param input the string that has to be checked
     * @return true if the string is between 3 and 8 chars long and the default validation was also successful
     */
    public static boolean validatePrefix(String input){
        return defaultValidation(input) && input.length()<8 && input.length()>3;
    }

}
