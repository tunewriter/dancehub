
describe('Checks Weekday Names (in German)', () => {
  const url = '/';
  const expectedWeekdays = ['Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag'];

  it('should read the text inside the <caption> tags', () => {
    cy.visit(url);

    cy.get('table').each(($table, index) => {
      cy.wrap($table)
        .find('caption')
        .invoke('text')
        .then((captionText) => {
          console.log('Caption text:', captionText);
          expect(captionText).to.equal(expectedWeekdays[index]);
        });
    });
  });
});

describe('Checks Total Number of Rows', () => {
  const url = '/';

  it('should check if the total number of <tr> elements across all tables is greater than 15', () => {
    cy.visit(url);
    cy.wait(2500);

    let totalRowCount = 0;

    cy.get('table')
      .each(($table) => {
        cy.wrap($table)
          .find('tbody tr')
          .its('length')
          .then((rowCount) => {
            totalRowCount += rowCount;
          });
      })
      .then(() => {
        expect(totalRowCount).to.be.greaterThan(15);
      });
  });
});


describe('Checks Length of Text of every Cell in First Row for each Weekday', () => {
  const url = '/';

  it('should check if the text in every <td> of the first <tr> is not empty', () => {
    cy.visit(url);

    cy.get('table').each(($table) => {
      cy.wrap($table)
        .find('tbody tr:first')
        .find('td')
        .each(($td) => {
          cy.wrap($td)
            .invoke('text')
            .then((tdText) => {
              expect(tdText.length).to.be.greaterThan(0);
            });
        });
    });
  });
});





