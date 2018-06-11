<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="SoftwareStudents">
                <UnitedStudents>
                    <xsl:for-each select="SoftwareStudents/softwarestudent">
                        <student>
                            <学号>
                                <xsl:value-of select="学号"/>
                            </学号>
                            <姓名>
                                <xsl:value-of select="姓名"/>
                            </姓名>
                            <院系>
                                <xsl:value-of select="院系"/>
                            </院系>
                        </student>
                    </xsl:for-each>
                </UnitedStudents>
            </xsl:when>
            <xsl:when test="CommerceStudents">
                <UnitedStudents>
                    <xsl:for-each select="CommerceStudents/commercestudent">
                        <student>
                            <学号>
                                <xsl:value-of select="sno"/>
                            </学号>
                            <姓名>
                                <xsl:value-of select="snm"/>
                            </姓名>
                            <院系>
                                <xsl:value-of select="sde"/>
                            </院系>
                        </student>
                    </xsl:for-each>
                </UnitedStudents>
            </xsl:when>
            <xsl:when test="MathStudents">
                <UnitedStudents>
                    <xsl:for-each select="MathStudents/mathstudent">
                        <student>
                            <学号>
                                <xsl:value-of select="学生编号"/>
                            </学号>
                            <姓名>
                                <xsl:value-of select="姓名"/>
                            </姓名>
                            <院系>
                                <xsl:value-of select="专业"/>
                            </院系>
                        </student>
                    </xsl:for-each>
                </UnitedStudents>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>