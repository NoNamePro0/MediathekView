/*    
 *    MediathekView
 *    Copyright (C) 2008   W. Xaver
 *    W.Xaver[at]googlemail.com
 *    http://zdfmediathk.sourceforge.net/
 *    
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mediathek.gui.dialog;

import javax.swing.JFrame;
import mediathek.daten.Daten;
import mediathek.res.GetIcon;
import mediathek.tool.EscBeenden;
import mediathek.tool.MVInfoFile;
import mSearch.daten.DatenFilm;

public class DialogFilmBeschreibung extends javax.swing.JDialog {

    DatenFilm datenFilm;
    JFrame paFrame;
    Daten daten;

    public DialogFilmBeschreibung(JFrame parent, Daten ddaten, DatenFilm ddatenFilm) {
        super(parent, true);
        paFrame = parent;
        daten = ddaten;
        initComponents();
        datenFilm = ddatenFilm;
        setTitle("Beschreibung ändern");
        if (parent != null) {
            setLocationRelativeTo(parent);
        }
        new EscBeenden(this) {
            @Override
            public void beenden_() {
                beenden();
            }
        };
        jTextArea1.setText(datenFilm.arr[DatenFilm.FILM_BESCHREIBUNG]);
        jTextFieldTitel.setText(datenFilm.arr[DatenFilm.FILM_TITEL]);
        jButtonOk.addActionListener(e -> {
            datenFilm.arr[DatenFilm.FILM_BESCHREIBUNG] = jTextArea1.getText();
            beenden();
        });
        jButtonHilfe.setIcon(GetIcon.getProgramIcon("help_16.png"));
        jButtonHilfe.addActionListener(e -> new DialogHilfe(paFrame, true, "\n"
                + "Diese Funktion richtet sich z.B. an Benutzer,\n"
                + "welche eine angepasste Beschreibung der Sendung in Form\n"
                + "der Infodatei (\"Filmname.txt\") anlegen\n"
                + "und durch Drittprogramme einlesen lassen wollen.\n"
                + "Achtung: Diese Änderungen gehen nach dem Neuladen\n"
                + "einer Filmliste verloren.").setVisible(true));
        jButtonSpeichern.addActionListener(e -> {
            datenFilm.arr[DatenFilm.FILM_BESCHREIBUNG] = jTextArea1.getText();
            MVInfoFile.writeInfoFile(paFrame, daten, datenFilm);
        });
        pack();
    }

    private void beenden() {
        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTitel = new javax.swing.JTextField();
        jButtonHilfe = new javax.swing.JButton();
        jButtonSpeichern = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("Ok");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Filmtitel:");

        jTextFieldTitel.setEditable(false);

        jButtonHilfe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediathek/res/programm/help_16.png"))); // NOI18N

        jButtonSpeichern.setText("Speichern");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSpeichern)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonHilfe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOk))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTitel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSpeichern)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonOk)
                            .addComponent(jButtonHilfe))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHilfe;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonSpeichern;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldTitel;
    // End of variables declaration//GEN-END:variables

}
