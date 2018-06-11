<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" indent="yes" method="xml"/>
    <xsl:template match="/">
        <CommerceCourses>
            <xsl:for-each select="UniteCourses/UniteCourse">
                <CommerceCourse>
                    <cno>
                        <xsl:value-of select="课程编号"></xsl:value-of>
                    </cno>
                    <cnm>
                        <xsl:value-of select="课程名称"></xsl:value-of>
                    </cnm>
                    <tec>
                        <xsl:value-of select="授课老师"></xsl:value-of>
                    </tec>
                    <share>
                        <xsl:value-of select="共享"></xsl:value-of>
                    </share>
                </CommerceCourse>
            </xsl:for-each>
        </CommerceCourses>
    </xsl:template>
</xsl:stylesheet>
