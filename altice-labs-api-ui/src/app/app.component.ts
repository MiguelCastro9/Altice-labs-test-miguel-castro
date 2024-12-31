import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LabSeqService } from './services/labSeq.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LabSeq } from './models/LabSeq';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet, 
    CommonModule, 
    FormsModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  labSeqsService = inject(LabSeqService);
  inputNumber: number | null = null;
  result: LabSeq | null = null;
  errorMessage: string = "";
  loadingResult: boolean = false;

  getLabSeq() {
    if (this.inputNumber !== null) {
      this.loadingResult = true;
      this.labSeqsService.labSeq(this.inputNumber).subscribe({
        next: (data) => {
          this.result = data;
        },
        error: (err) => {
          this.errorMessage = err.error;
        },
      });
      this.loadingResult = false;
    }
  }
}
