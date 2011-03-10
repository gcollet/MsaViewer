//
//  MsaView.java
//  MsaView
//
//  Created by COLLET Guillaume on 10/03/11.
//  Copyright (c) 2011 Bill Psyko Systems. All rights reserved.
//
//  A simple signed Java applet
//

import java.awt.*;
import java.applet.*;
import javax.swing.*;


public class MsaView extends JApplet {
	
	private JScrollPane msaPanel;
	private JTextField posTextField;
	private JButton valider;
	private JLabel titre;
	private JTextArea msaSeq;
	private Panel headerLine, graphLine;
	private Histo histograph;
	public void init(){
		setBackground(Color.WHITE);
		
		// Création des éléments d'interface
		String fname  = getCodeBase() + "/" + getParameter("file");
		
		valider       = new JButton("Valider");
		titre         = new JLabel("MsaViewer");
		headerLine    = new Panel();
		graphLine    = new Panel();
		posTextField = new JTextField("Positions separated by comma");
		
		headerLine.setBackground(Color.black);
		graphLine.setBackground(Color.black);
		
		msaSeq = new JTextArea("     1   5   10    15    20    25    30    35    40    45    50    55    60    65    70    75    80    85    90    95   100   105   110   115   120   125   130   135   140   145   150   \n");
		msaSeq.setEditable(false);
		msaSeq.setFont(new Font("Courier New", Font.PLAIN, 14));
		msaSeq.append("     |   |    |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |   \n");
		msaSeq.append("   1 MAHHHHHHMMKEETLNSDNSSAEVSVESPSFSFNCAHFIAYNGFRETLHGHNYNVSLKVRGYVRDDGYVIDFSILKEKVKKVCNKLDHHFILPIYSDVLKFENVKNNIKIICEDNSEYSFPERDCIKLPIKHSSTEEIGQYILNQLIEEXDVSLLKSRHIHYIEISVSESPTQKAIVHKYI\n");
		msaSeq.append("   2 MAHHHHHHMMKEETLNSDNSSAEVSVESPSFSFNCAHFIAYNGFRETLHGHNYNVSLKVRGYVRDDGYVIDFSILKEKVKKVCNKLDHHFILPIYSDVLKFENVKNNIKIICEDNSEYSFPERDCIKLPIKHSSTEEIGQYILNQLIEEXDVSLLKSRHIHYIEISVSESPTQKAIVHKYI\n");
		msaSeq.append("   3 ---------MNPHPVEPRDQIAELLVESPLFSFNCAHFIAFKGFRETLHGHNYNVSLRLRGNIQGDGYVIDFSILKEKVRKVCKQLDHHFILPMYSDVLNIQEVNDNFKITCEDNSEYSFPKRDCVQIPIKHSSTEEIGLYILNQLIEEIDLPFLKTRSVNYMEVTVSESPSQKATVHRNI\n");
		msaSeq.append("   4 --------IMSNDLLKSENNIAELLVESPAFTFHCAHFIAYKGFRETLHGHNYNVSLKVKGHIQSDGYVVDFSILKKIVKNICNTIDHRFIIPTKSDVLKIEKINNNFQLTCEDNSVYSFPQNDCVEIPIKHSSTEEIGHYILSKIIDEIGMDFLKSRSVNYIEISVSESQTQKAMVCRYI\n");
		msaSeq.append("   5 ----------RPAEFGADLSSGEVLVQAPSMKFNCGHFIAYRGFRERLHGHNYSVTVKIGGIVGPDGYILDFGDIKQTAREVCKSLDEHLIVPMKSDVLDITQEGQSIIIRCEDGAEFKVPCSDCKCLPIVHSSAEEITCYLWQCIVDKVTVPLLKKRGATWVEVAVWETPSQMASFRREV\n");
		msaSeq.append("   6 -------------------------YLTVGSHFSAAHRLALPGKCARPHGHNYHLEVTVKGEVDATGMIVDLVALQSLVDDVLDPLDHTFLN------------------------------KDIPYFEKVVPTAENIAFYIAKLLRE-----PILKIGAELHRIKLIESPNNSCEV----\n");
		msaSeq.append("   7 ------------------------CLIHRRAEFSASHRYWLPGQCTRGHGHNYELFVSMWGELDQYGMVLNLSNVKQVIKEVTAPLNFSYLNEV------------------------------WPEFKETLPTTEHLARVIWQRLEPHLP----------IVNIQLFEHPKLWADYKG--\n");
		msaSeq.append("   8 ---------------------------TRRFNFSASHRYWREGKCTNGHGHNYELFVTVAGAVDPTGMVMNMVELKRLVTMVLDQFDHKHLNE------------------------------DTPYFREVIPTTENLVRVLWGLIEPQ------LPKGVRLAKLRLYENSDLYAEYFG--\n");
		msaSeq.append("   9 -----------------------MIQITRRETFNAAHRLFNPGPCSKVHGHNWELFVTVIGEVEDTGFVVDLKALSRTMREVISKVDHTYLNE------------------------------DVAFLAGKLPTTENFAIAIWDILKPAIKQK----HGVDLYKIKLTETANHYVEYFG--\n");
		msaSeq.append("  10 --------IQQFYPQVPHSY---RFELNKDMHLAAAHFINDEGACQNIHGHTYFINVTIAGELDSTGFLINFKNIKTL---VHKRYDHSLLNEHK-------------------------------EYEDLDPTTEVVAMQIWETIQSHLDTLSNQP---KCIQVLVRETPTSYVVYR---\n");
		msaSeq.append("  11 -----------------------MFAIGVVAQFEAAHRLRGDGPASRLHGHTYRVEVEVAGPLNDDGTLFDLGLLKAWVDEAVGELNYQNLD-------------------------------VLPAFAQRNSTAEEVARFLRETLAPR-----LHGKGLRMLTVRVWESPQAYAACQWEL\n");
		msaSeq.append("  12 ---------------------MKLF-VRDLTVIDASYLCTDRG----MVGESWILDVVMSGELNEMSMVLDFSRVKKQIKQLVDQYDHRLIVPAKSPAIHTAATKTGYALREDKNIHLHCPEEAFCFIDAETVTIESVTEHVYHVLKD------NLPENVQGLEVVLRHEVIQGAFYH---\n");
		msaSeq.append("  13 --------------MNDLLEKPRKIYVSRSIEFNAAHRLCNPGKCNNPHGHNYLLTITLSGTINQTGFLFDLKALKAILEEIVERFDHKHLN------------------------------YDVPELSNCIPTTEILAVLIWDILAQRFTTIN---PAITLHEVHLYETGKNAVRYYGE-\n");
		msaSeq.append("  14 -----------------------RVTVHRKAHFNAAHRLYRKGLCNNPHGHNYELIASVTGEIDETGYVIDVKILKGIIKEVEDAFDHKNLN------------------------------VEVEEFKDLNPTAENIAVVIYDKVKAKLDPKFHL-------EITLYETPRNFVTYSGE-\n");
		msaSeq.append("  15 -----------------------MIQITRRETFNAAHRLFNPGPCSKVHGHNWELFVTVIGEVEDTGFVVDLKALSRTMREVISKVDHTYLNE------------------------------DVAFLAGKLPTTENFAIAIWDILKPAIKQK----HGVDLYKIKLTETANHYVEYFG--\n");
		msaSeq.append("  16 --------IQQIYPAPIHSY---RYELNKDMHVAAAHYIDDEGRCQRVHGHTYFINLTIVGDLDETGFLVNFSKLKQA---VHGRFDHRLLNED-------------------------------TLFETAPPSTEKMAETIYKVVQEQLDTCPNRPL---CIQVYVRETPTSYVVYR---\n");
		msaSeq.append("  17 ----------------------RICVGVENLDFDAAHYT--KGISDNIHGHTFKVSVEVCGDIQDTGMVIDFGILKNVLKKIINEYDHTIIVPKMDKIIIKGPFKSKIKVI-----DYPEATTEYIALDIAKRVKEELGLYVKVKLYE---------------------------------\n");
		msaSeq.append("  18 ---------------------------SVSTTFDAAHFLKYDGKCANLHGHTWRVEAEVEGQTTNDGLLIDFGMIKDYLKDITSRLDHKLL----NDVLQVNPTAENI-------------------------------------------------------------------------\n");
		msaSeq.append("  19 ------------------------------FDFDAAHFLPYNGKCEHLHGHTYKLVVKVEGTPDHEGMVLDFVRFKNLVKEVVSKLDHAFI----NDILPQPSAEN---------------------------------------------------------------------------\n");
		msaSeq.append("  20 ------------------SSRGENMVLVKKFSFEAAHLVKYHGKCERLHGHTYRLTVKVEGPLNEEDMVMDFAELKKMVERVIKKLDHSYL------------------------------------------------------------------------------------------\n");
		msaSeq.append("  21 ------------------------------FTFDSAHLINYNGKCEELHGHTYKLEVTVEGKPDGEGMVIDFVKLKEIVEKVVKKLDHKYL----NEVLGFNTTCENI-------------------------------------------------------------------------\n");
		msaSeq.append("  22 ------------------------------FTFDSAHLTKYNGKCENLHGHTYKLEVTVEGSVNDEGIVIDFAELKAIVEQVVKKLDHMYL----NDVLGFNTTCENI-------------------------------------------------------------------------\n");
		msaSeq.append("  23 -----------------------VRIAKDNLVFSAGHFITFAGGTERVHGHNYRVEAEIFGPLDENHYVVDFIAARDALAQIVGELDHRMLLPTAHP--QIDVVADGKEVTAKEERRWVFPQAECVLLPVPNTTTELLARYVGRRLLD-----LLQERRPQHLRIAIDENYGQWGV-----\n");
		msaSeq.append("  24 --------------MNEKKYLTTVELQKESMKFSAGHTTIFSATREPLHGHMYGVYLALTTWVEENGMTFDYRYYKERIHKLCRYLNQTFLMPQYSPFLEY----------AEDEAYYYFTKEDVTLLPVTNITVEELSKWFVHELIQDKDE--LDRHRIEKVVVKVFSAPGQSA------\n");
		msaSeq.append("  25 -----------------------------GLRFSSAHIVFGHDSCGVIHGHSYYVDVKVCGAPSGEGFVCDFKILKKIVKNICGKLDHKLLIPENHPNLKY-NIENNAITFCKGDKEYKIPLEDVVLLPILSTTAEELSKYFAEHIKMEL-CTLNLENSIDWIEATVNEGIGQGA------\n");
		
		msaPanel = new JScrollPane(msaSeq,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		msaPanel.setBackground(Color.WHITE);
		// Création des Contenants permettant de placer les objets de l'interface
		GridBagLayout mainGrid    			= new GridBagLayout();		// Sert à placer les objets dans la fenêtre
		GridBagConstraints constraints	= new GridBagConstraints();	// Sert à définir les placements sur la grille 
		getContentPane().setLayout(mainGrid);
		
		// JPanel pour placer le header
		GridBagLayout headerGrid = new GridBagLayout();
		Panel headerPanel = new Panel(headerGrid);
		headerPanel.setBackground(Color.WHITE);
		
		// JPanel pour placer le graphe
		GridBagLayout graphGrid = new GridBagLayout();
		Panel graphPanel = new Panel(graphGrid);
		graphPanel.setBackground(Color.WHITE);	
		
		// Placement des différents panel
		// Placement du headerPanel
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth  = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.weightx = 100;
		constraints.weighty = 0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		mainGrid.setConstraints(headerPanel, constraints);
		getContentPane().add(headerPanel);
		
		// Placement du graphPanel
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth  = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.weightx = 100;
		constraints.weighty = 0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		mainGrid.setConstraints(graphPanel, constraints);
		getContentPane().add(graphPanel);
		
		// Placement du msaPanel
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth  = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.weightx = 100;
		constraints.weighty = 100;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		mainGrid.setConstraints(msaPanel, constraints);
		getContentPane().add(msaPanel);
		
		// Placement du Titre dans le panel headerPanel
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth  = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.weightx = 0;
		constraints.weighty = 99;
		constraints.insets = new Insets(3,5,3,3);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		headerGrid.setConstraints(titre, constraints);
		headerPanel.add(titre);
		// Placement du headeLine dans le headerPanel
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth  = 2;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.SOUTH;
		constraints.weightx = 100;
		constraints.weighty = 1;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 2;
		headerGrid.setConstraints(headerLine, constraints);
		headerPanel.add(headerLine);
		//Placement du posTextField dans le graphPanel
		posTextField.setMinimumSize(new Dimension(200,30));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth  = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		graphGrid.setConstraints(posTextField, constraints);
	  graphPanel.add(posTextField);
		
		// Placement du bouton valider dans le graphPanel
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth  = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		graphGrid.setConstraints(valider, constraints);
	  graphPanel.add(valider);
		// Placement du headeLine dans le headerPanel
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth  = 2;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.SOUTH;
		constraints.weightx = 100;
		constraints.weighty = 0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		graphGrid.setConstraints(graphLine, constraints);
		graphPanel.add(graphLine);
	
	}
}
