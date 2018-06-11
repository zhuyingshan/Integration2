<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

	<xsl:template match="/">
		<CommerceSelectionList>
			<xsl:choose>
				<xsl:when test="UniteSelectionList">
					<xsl:for-each select="UniteSelectionList/UniteSelection">
						<CommerceSelection>
							<xsl:attribute name="cns">
								<xsl:value-of select="课程编号"/>
							</xsl:attribute>
							<xsl:attribute name="sno">
								<xsl:value-of select="学生编号"/>
							</xsl:attribute>
							<xsl:attribute name="grd">
								<xsl:value-of select="分数"/>
							</xsl:attribute>
						</CommerceSelection>
					</xsl:for-each>
				</xsl:when>
			</xsl:choose>
		</CommerceSelectionList>
	</xsl:template>
</xsl:stylesheet>