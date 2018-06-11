<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" indent="yes" method="xml"/>
    <xsl:template match="/">
        <SoftwareCourses>
            <xsl:for-each select="UniteCourses/UniteCourse">
                <SoftwareCourse>
                    <课程编号>
                        <xsl:value-of select="课程编号"></xsl:value-of>
                    </课程编号>
                    <课程名称>
                        <xsl:value-of select="课程名称"></xsl:value-of>
                    </课程名称>
                    <授课老师>
                        <xsl:value-of select="授课老师"/>
                    </授课老师>
                    <共享>
                        <xsl:value-of select="共享"/>
                    </共享>
                </SoftwareCourse>
            </xsl:for-each>
        </SoftwareCourses>


    </xsl:template>
</xsl:stylesheet>
