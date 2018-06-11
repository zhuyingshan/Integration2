<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <SoftwareStudents>
            <xsl:for-each select="UnitedStudents/student">
                <softwarestudent>
                    <学号>
                        <xsl:value-of select="学号"/>
                    </学号>
                    <姓名>
                        <xsl:value-of select="姓名"/>
                    </姓名>
                    <院系>
                        <xsl:value-of select="院系"/>
                    </院系>
                </softwarestudent>
            </xsl:for-each>
        </SoftwareStudents>
    </xsl:template>
</xsl:stylesheet>