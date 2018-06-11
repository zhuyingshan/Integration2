<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" indent="yes" method="xml"/>
    <xsl:template match="/">
        <MathCourses>
            <xsl:for-each select="UniteCourses/UniteCourse">
                <MathCourse>
                    <编号>
                        <xsl:value-of select="课程编号"></xsl:value-of>
                    </编号>
                    <名称>
                        <xsl:value-of select="课程名称"></xsl:value-of>
                    </名称>
                    <老师>
                        <xsl:value-of select="授课老师"></xsl:value-of>
                    </老师>
                    <共享>
                        <xsl:value-of select="共享"></xsl:value-of>
                    </共享>
                </MathCourse>
            </xsl:for-each>
        </MathCourses>
    </xsl:template>
</xsl:stylesheet>
