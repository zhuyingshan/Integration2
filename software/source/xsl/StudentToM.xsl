<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
    <xsl:output method="xml" indent="yes"  encoding="UTF-8"/>
	<xsl:template match="/">
		<MathStudents>
		    <xsl:for-each select="UnitedStudents/student">
				<mathstudent>
				<学生编号>
					<xsl:value-of select="学号"/>
				</学生编号>
				<姓名>
					<xsl:value-of select="姓名"/>
				</姓名>
				<专业>
					<xsl:value-of select="院系"/>
				</专业></mathstudent>
			</xsl:for-each>
		</MathStudents>
	</xsl:template>
</xsl:stylesheet>