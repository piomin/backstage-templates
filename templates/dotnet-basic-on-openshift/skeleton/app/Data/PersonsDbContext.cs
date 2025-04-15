
using Microsoft.EntityFrameworkCore;
using app.Model;

namespace app.Data {
    public class PersonsDbContext : DbContext
    {
    
        public PersonsDbContext(DbContextOptions<PersonsDbContext> options) : base(options)
        {
        }


        public DbSet<Person> Persons { get; set; }

    }
}