package controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import modelo.Informe;
import modelo.Proyecto;
import modelo.Tarea;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

public class ControladorTree {
    ControladorPrincipal controladorPrincipal;
    JTree tree;
    ArrayList<Proyecto> proyectos;

    final FlatSVGIcon iconoTarea = new FlatSVGIcon("imagenes/list.svg",24,24);
    final FlatSVGIcon iconoProyecto = new FlatSVGIcon("imagenes/framework.svg",24,24);
    FlatSVGIcon.ColorFilter filtro = new FlatSVGIcon.ColorFilter((Color t) -> new Color(175, 177, 179));

    public ControladorTree(ControladorPrincipal controller){
        controladorPrincipal = controller;
        proyectos = controladorPrincipal.model.getProyectos();
        estalizarIconos();
        initTree();
    }

    private void initTree(){
        tree = controladorPrincipal.ventana.jTreeProyectos;
        tree.setCellRenderer(estilizarTree());
        tree.setRootVisible(false);
        eventos();
        actualizarTree();
    }

    private void estalizarIconos(){
        iconoProyecto.setColorFilter(filtro);
        iconoTarea.setColorFilter(filtro);
    }

    private DefaultTreeCellRenderer estilizarTree(){
        DefaultTreeCellRenderer estilizarTree = new DefaultTreeCellRenderer(){
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode valor = (DefaultMutableTreeNode) value;
            super.getTreeCellRendererComponent(tree, value, selected,expanded, leaf, row, hasFocus);
            //altura de cada nodo
//                tree.setRowHeight(26);
            if ( valor.getUserObject() instanceof Tarea)
                setIcon (iconoTarea);

            if ( valor.getUserObject() instanceof Proyecto)
                setIcon(iconoProyecto);
            return this;
        }};
        return estilizarTree;
    }

    public void actualizarTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();

        for(Proyecto proyecto : proyectos){
            DefaultMutableTreeNode treeNodeProyecto = new DefaultMutableTreeNode(proyecto);
            root.add(treeNodeProyecto);
            ArrayList<Tarea> tareasAgregadas = new ArrayList<>();
            for(Tarea tarea : proyecto.getTareas()){
                if (!tareasAgregadas.contains(tarea)){
                    DefaultMutableTreeNode treeNodeTarea = new DefaultMutableTreeNode(tarea);
                    treeNodeProyecto.add(treeNodeTarea);
                    tareasAgregadas.addAll(cargarSubTareas(treeNodeTarea,proyecto));
                }
            }
        }

        DefaultTreeModel modelo = new DefaultTreeModel(root);
        tree.setModel(modelo);
    }

    private ArrayList<Tarea> cargarSubTareas(DefaultMutableTreeNode treeNodeTareaPadre, Proyecto proyecto){
        ArrayList<Tarea> tareasAgregadas = new ArrayList<>();

        for(Tarea tarea : proyecto.subTareas((Tarea)treeNodeTareaPadre.getUserObject())){
            DefaultMutableTreeNode treeNodeTarea = new DefaultMutableTreeNode(tarea);
            treeNodeTareaPadre.add(treeNodeTarea);
            tareasAgregadas.add(tarea);
            tareasAgregadas.addAll(cargarSubTareas(treeNodeTarea,proyecto));
        }

        return tareasAgregadas;
    }

    private void eventos(){
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if(tree.getLastSelectedPathComponent() != null)
                    controladorPrincipal.informeActivo = (Informe)((DefaultMutableTreeNode)tree.getLastSelectedPathComponent()).getUserObject();
//                else
//                    controladorPrincipal.informeActivo = null;

            }
        });
    }


}
