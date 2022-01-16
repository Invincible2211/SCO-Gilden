package de.fynn.sco.guild.system.messages;

/**
 * @author Freddyblitz
 */

public enum Prefix {

        COMMAND(""),
        INFO(""),
        ERROR(""),
        GUILD(""),
        QUESTION("");

        private String value;

        private Prefix(String value){
                this.value = value;
        }

        public String getValue(){
                return value;
        }
}
