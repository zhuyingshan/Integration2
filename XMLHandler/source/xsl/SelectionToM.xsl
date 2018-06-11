<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>
	<xsl:template match="/">
		<MathSelectionList>
			<xsl:choose>
				<xsl:when test="UniteSelectionList">
					<xsl:for-each select="UniteSelectionList/UniteSelection">
						<MathSelection>
							<xsl:attribute name="课程编号">
								<xsl:value-of select="课程编号"/>
							</xsl:attribute>
							<xsl:attribute name="学号">
								<xsl:value-of select="学生编号"/>
							</xsl:attribute>
							<xsl:attribute name="分数">
								<xsl:value-of select="分数"/>
							</xsl:attribute>
						</MathSelection>
					</xsl:for-each>
				</xsl:when>
			</xsl:choose>
		</MathSelectionList>
	</xsl:template>
</xsl:stylesheet>