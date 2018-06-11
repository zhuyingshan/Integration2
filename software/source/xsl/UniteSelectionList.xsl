<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

	<xsl:template match="/">
		<xsl:choose>
			<xsl:when test="SoftwareSelectionList">
				<UniteSelectionList>
					<xsl:for-each select="SoftwareSelectionList/SoftwareSelection">
						<UniteSelection>
							<xsl:attribute name="课程编号">
								<xsl:value-of select="课程编号"/>
							</xsl:attribute>
							<xsl:attribute name="学生编号">
								<xsl:value-of select="学生编号"/>
							</xsl:attribute>
							<xsl:attribute name="分数">
								<xsl:value-of select="成绩"/>
							</xsl:attribute>
						</UniteSelection>
					</xsl:for-each>
				</UniteSelectionList>
			</xsl:when>
			<xsl:when test="MathSelectionList">
				<UniteSelectionList>
					<xsl:for-each select="MathSelectionList/MathSelection">
						<UniteSelection>
							<xsl:attribute name="课程编号">
								<xsl:value-of select="课程编号"/>
							</xsl:attribute>
							<xsl:attribute name="学生编号">
								<xsl:value-of select="学号"/>
							</xsl:attribute>
							<xsl:attribute name="分数">
								<xsl:value-of select="分数"/>
							</xsl:attribute>
						</UniteSelection>
					</xsl:for-each>
				</UniteSelectionList>
			</xsl:when>
			<xsl:when test="CommerceSelectionList">
				<UniteSelectionList>
					<xsl:for-each select="CommerceSelectionList/CommerceSelection">
						<UniteSelection>
							<xsl:attribute name="课程编号">
								<xsl:value-of select="cns"/>
							</xsl:attribute>
							<xsl:attribute name="学生编号">
								<xsl:value-of select="sno"/>
							</xsl:attribute>
							<xsl:attribute name="分数">
								<xsl:value-of select="grd"/>
							</xsl:attribute>
						</UniteSelection>
					</xsl:for-each>
				</UniteSelectionList>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>