package com.finalmas.app.views;

import com.finalmas.app.model.Policy;
import com.finalmas.app.repository.PolicyRepository;
import com.finalmas.app.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@PageTitle("Main")
@Route(value = "")
@AnonymousAllowed

public class PolicyPackageView extends AppLayout {

private final PolicyRepository policyRepository;
    private Button add;
    private Button next;
    private Tabs tabs;
    private H1 title;
    private H1 pageTitle;
    private H2 opis;
    private DrawerToggle toggle;
    private TextField policyName;
    private TextArea textArea;
    private Image img;
    private DatePicker createDate;
    private DatePicker wefDate;
    private Paragraph paragraph;
    private NumberField dollarField;

    private NumberField counterField;

    private final SecurityService securityService;

    private Map<String, Policy> policyMap = new HashMap<>();
    public static Map<String, Policy> chosenMap = new HashMap<>();

    public PolicyPackageView(PolicyRepository policyRepository, SecurityService securityService) {
        this.policyRepository = policyRepository;

        this.securityService = securityService;
        List<Policy> policyList = policyRepository.findAll();

        this.setHeader();
        this.setMenu(policyList);
        this.setPage(policyList);

    }

    private void setHeader(){
        toggle = new DrawerToggle();
        title = new H1("Ganimedes inc.");

        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        img = new Image("data:image/jpeg;base64,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", "Gaminedes inc Logo");
        img.setHeight("44px");

        addToNavbar(toggle, title,img);
    }

    private void setMenu(List<Policy> policyList){
        opis = new H2("Available policy");

        tabs = new Tabs();

        for (Policy pol : policyList) {
            tabs.add(new Tab(pol.name));
            policyMap.put(pol.name, pol);
        }


        pageTitle  = new H1("Choose policy templates!");
        policyName = new TextField("Policy name");



        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        setPrimarySection(Section.DRAWER);


        addToDrawer(opis, tabs);
    }

    private void setPage(List<Policy> policyList){
        FormLayout formLayout = new FormLayout();

        policyName.setEnabled(false);
        policyName.setValue(policyList.get(0).name);

        textArea = new TextArea();
        textArea.setLabel("Description");
        textArea.setValueChangeMode(ValueChangeMode.EAGER);
        textArea.setValue(policyList.get(0).description);
        textArea.setEnabled(false);


        createDate = new DatePicker("Create Date");
        createDate.setValue(policyList.get(0).creation_date);
        createDate.setEnabled(false);

        wefDate = new DatePicker("Warrancy Date");
        wefDate.setValue(policyList.get(0).usefullness_date);
        wefDate.setEnabled(false);
        paragraph = new Paragraph("Policy details:");

        dollarField = new NumberField();
        dollarField.setLabel("Insurane sum");
        dollarField.setValue(policyList.get(0).sum_insured);
        Div dollarPrefix = new Div();
        dollarPrefix.setText("$");
        dollarField.setPrefixComponent(dollarPrefix);
        dollarField.setEnabled(false);

        counterField = new NumberField();
        counterField.setValue((double) chosenMap.size());
        Div numberPrefix = new Div();
        numberPrefix.setText("Chosen policy number: ");
        counterField.setPrefixComponent(numberPrefix);
        counterField.setEnabled(false);

        add = new Button("Add policy");
        next = new Button("Buy policy package");

        if (chosenMap.keySet().size() == 0)
            next.setEnabled(false);

        add.addClickListener(e -> {
            Notification.show("Added " +  policyName.getValue());
            next.setEnabled(true);
            String nameValue = policyName.getValue();
            while (true) {
                if (!chosenMap.containsKey(policyName.getValue())) {
                    if (policyName.getValue() != null) {
                        Policy policy = new Policy(policyMap.get(nameValue).name, policyMap.get(nameValue).description, policyMap.get(nameValue).creation_date,
                                policyMap.get(nameValue).usefullness_date, policyMap.get(nameValue).sum_insured);
                        chosenMap.put(policyName.getValue(), policy);
                    }
                    break;
                } else {
                    if (Objects.equals(policyName.getValue().split("")[policyName.getValue().split("").length - 1], ")")){
                        double tt = Double.parseDouble(policyName.getValue().split("")[policyName.getValue().split("").length - 2])+1;
                        policyName.setValue(policyName.getValue().split("\\(")[0] +"("+ (int)tt + ")");
                    } else {
                        policyName.setValue(policyName.getValue()+"(2)");
                    }
                }
            }
            policyName.setValue(nameValue);
            counterField.setValue(counterField.getValue()+1);
        });

        next.addClickListener(e -> {
            next.getUI().ifPresent(ui ->
                    ui.navigate("policy"));
        });

        tabs.addSelectedChangeListener(e -> {
            Notification.show("Chosen " +  e.getSelectedTab().getLabel());
            policyName.setValue(e.getSelectedTab().getLabel());
            textArea.setValue(policyMap.get(e.getSelectedTab().getLabel()).description);
            createDate.setValue(policyMap.get(e.getSelectedTab().getLabel()).creation_date);
            wefDate.setValue(policyMap.get(e.getSelectedTab().getLabel()).usefullness_date);
            dollarField.setValue(policyMap.get(e.getSelectedTab().getLabel()).sum_insured);
        });

        formLayout.add(pageTitle, counterField, paragraph,  policyName, textArea, createDate, wefDate,
                dollarField, add, next);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 2));
        formLayout.setColspan(policyName, 2);
        formLayout.setColspan(paragraph, 2);
        formLayout.setColspan(textArea, 2);
        formLayout.setColspan(dollarField, 2);

        setContent(formLayout);
    }
}
