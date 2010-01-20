<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" omit-xml-declaration="no"/>

    <xsl:template match="/">
        <users>
            <xsl:for-each select="users/user">
                <user>
                    <username><xsl:value-of select="username"/></username>
                    <firstname><xsl:value-of select="firstname"/></firstname>
                    <lastname><xsl:value-of select="lastname"/></lastname>
                    <email><xsl:value-of select="email"/></email>
                </user>
            </xsl:for-each>
        </users>
    </xsl:template>

</xsl:stylesheet>