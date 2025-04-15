using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using app.Model;
using app.Data;

namespace app.Controllers
{
    [ApiController]
    [Route("persons")]
    public class PersonController : ControllerBase
    {
        private readonly ILogger<PersonController> _logger;
        private readonly List<Person> _persons = new List<Person>();
        private readonly PersonsDbContext _context;

        public PersonController(ILogger<PersonController> logger, PersonsDbContext context)
        {
            _logger = logger;
            _context = context;
            _persons.Add(new Person {Id = 1, Name = "Test1", Age = 20});
            _persons.Add(new Person {Id = 2, Name = "Test2", Age = 30});
            _persons.Add(new Person {Id = 3, Name = "Test3", Age = 40});
        }

        [HttpGet]
        public List<Person> FindAll()
        {
            _logger.LogInformation("Find All");
            return _context.Persons.ToList();
        }
        
        [HttpGet("{id:int}")]
        public Person FindById(int id)
        {
            _logger.LogInformation("Find By Id={Id}", id);
            return _context.Persons.Find(id);
        }

        [HttpGet("age-greater-than/{age:int}")]
        public List<Person> FindByAgeGreaterThan(int age) {
            _logger.LogInformation("Find By Age>{age}", age);
            return _context.Persons.Where(person => person.Age > age).ToList();
        }

        [HttpPost]
        public Person AddNew([FromBody] Person person)
        {
            _logger.LogInformation("Add New Name={Name}", person.Name);
            var addedPerson = _context.Persons.Add(person);
            _context.SaveChanges();
            return person;
        }
    }
}