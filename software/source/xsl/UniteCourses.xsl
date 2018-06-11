<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" indent="yes" method="xml"/>
    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="SoftwareCourses">
                <UniteCourses>
                    <xsl:for-each select="SoftwareCourses/SoftwareCourse">
                        <UniteCourse>
                            <课程编号>
                                <xsl:value-of select="课程编号"></xsl:value-of>
                            </课程编号>
                            <课程名称>
                                <xsl:value-of select="课程名称"></xsl:value-of>
                            </课程名称>
                            <授课老师>
                                <xsl:value-of select="授课老师"></xsl:value-of>
                            </授课老师>
                            <共享>
                                <xsl:value-of select="共享"></xsl:value-of>
                            </共享>
                        </UniteCourse>
                    </xsl:for-each>
                </UniteCourses>
            </xsl:when>

            <xsl:when test="MathCourses">
                <UniteCourses>
                    <xsl:for-each select="MathCourses/MathCourse">
                        <UniteCourse>
                            <课程编号>
                                <xsl:value-of select="编号"></xsl:value-of>
                            </课程编号>
                            <课程名称>
                                <xsl:value-of select="名称"></xsl:value-of>
                            </课程名称>
                            <授课老师>
                                <xsl:value-of select="老师"></xsl:value-of>
                            </授课老师>
                            <共享>
                                <xsl:value-of select="共享"></xsl:value-of>
                            </共享>

                        </UniteCourse>
                    </xsl:for-each>
                </UniteCourses>
            </xsl:when>

            <xsl:when test="CommerceCourses">
                <UniteCourses>
                    <xsl:for-each select="CommerceCourses/CommerceCourse">
                        <UniteCourse>
                            <课程编号>
                                <xsl:value-of select="cno"></xsl:value-of>
                            </课程编号>
                            <课程名称>
                                <xsl:value-of select="cnm"></xsl:value-of>
                            </课程名称>
                            <授课老师>
                                <xsl:value-of select="tec"></xsl:value-of>
                            </授课老师>
                            <共享>
                                <xsl:value-of select="share"></xsl:value-of>
                            </共享>

                        </UniteCourse>
                    </xsl:for-each>
                </UniteCourses>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>
